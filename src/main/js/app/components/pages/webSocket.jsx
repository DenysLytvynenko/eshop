import React from 'react';
import SockJsClient from 'react-stomp';
import {PulseLoader} from 'react-spinners';
import {
    Alert,
    Container,
    Row,
    Col,
    Button,
    Input,
    InputGroupAddon,
    InputGroup,
    Jumbotron
} from 'reactstrap';
import {FormattedMessage, injectIntl, intlShape} from "react-intl";

import {baseUrl} from 'app/service/baseUrl'

const urlWebSocket = baseUrl + '/endpoint';
const connectionStatusOpen = 'WebSocket connection: open';
const connectionStatusClose = 'WebSocket connection: close';

class WebSocketLayout extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            gotMessages: [],
            sendMessage: '',
            connectionStatus: 'danger',
            connectionMessage: connectionStatusClose
        };

        this.sendMessage = this.sendMessage.bind(this);
        this.handleKeyDown = this.handleKeyDown.bind(this);
    }

    sendMessage() {
        this.clientRef.sendMessage("/client/message", this.state.sendMessage);
        this.setState({sendMessage:''});
    }

    handleKeyDown(e) {
        if (e.key === 'Enter') {
            this.sendMessage();
        }
    }

    render() {
        const {sendMessage, gotMessages, connectionStatus, connectionMessage} = this.state;
        const {intl} = this.props;

        return (
            <div>
                <Jumbotron>
                    <h5><FormattedMessage id='app.page.websocket.text'/></h5>
                </Jumbotron>
                <Container>
                    <Row>
                        <Col>

                            <Alert color={connectionStatus}>
                                <PulseLoader
                                    sizeUnit={"px"}
                                    size={30}
                                    color={'#FFF'}
                                    loading={connectionStatus === 'danger'}
                                />
                                {connectionMessage}
                            </Alert>
                        </Col>
                    </Row>
                    <Row>
                        <Col>
                            <InputGroup>
                                <Input
                                    type="text"
                                    placeholder={intl.formatMessage({id: 'app.websocket.input.message'})}
                                    value={sendMessage}
                                    onChange={value => this.setState({sendMessage: value.target.value})}
                                    onKeyDown={this.handleKeyDown}/>
                                <InputGroupAddon addonType="append">
                                    <Button
                                        color="primary"
                                        onClick={() => {
                                            this.sendMessage()
                                        }}>
                                        <FormattedMessage id='app.websocket.button.send'/>
                                    </Button>
                                </InputGroupAddon>
                            </InputGroup>
                        </Col>
                    </Row>
                    <Row>
                        <Col>
                            <br/>
                            <Alert color="info">
                                <ul>
                                    {gotMessages.map((value, index) => {return <li key={index}>{value}</li>})}
                                </ul>
                            </Alert>
                            <SockJsClient url={urlWebSocket}
                                          topics={['/server/message']}
                                          autoReconnect={true}
                                          onConnect={() => {
                                              this.setState({
                                                  connectionStatus: 'success',
                                                  connectionMessage: connectionStatusOpen
                                              })
                                          }}
                                          onDisconnect={() => {
                                              this.setState({
                                                  connectionStatus: 'danger',
                                                  connectionMessage: connectionStatusClose
                                              })
                                          }}
                                          onMessage={(response) => {
                                              var newGotMessages = this.state.gotMessages;
                                              newGotMessages.push(response.message);
                                              this.setState({gotMessages: newGotMessages})
                                          }}
                                          ref={(client) => {
                                              this.clientRef = client
                                          }}/>
                        </Col>

                    </Row>

                </Container>

            </div>
        );
    }
}

WebSocketLayout.propTypes = {
    intl: intlShape.isRequired
};

export default injectIntl(WebSocketLayout);