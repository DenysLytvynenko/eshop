import React, {useState} from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import {
    Button,
    Nav,Navbar,NavbarBrand,NavItem,NavLink,
    Dropdown, DropdownToggle, DropdownMenu, DropdownItem, UncontrolledDropdown,
    FormGroup, Input
} from 'reactstrap';
import Locale from 'app/components/locale';
import {FormattedMessage} from 'react-intl';

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faPhone, faDrumstickBite } from '@fortawesome/free-solid-svg-icons'

import * as routers from 'app/constants/routes'
import ApplicationRouter from 'app/router/routerSwitch';

export default function IndexLayout(props) {

    return (
        <div>
            <Navbar color='secondary' expand='lg'>
                <div className="container">
                    <FontAwesomeIcon icon={faPhone} />
                    <FormattedMessage id='header.callUs'/>
                    <FormattedMessage id='header.phone' />
                    <UncontrolledDropdown size="sm" >
                        <DropdownToggle caret>BGN</DropdownToggle>
                        <DropdownMenu>
                            <DropdownItem>BGN</DropdownItem>
                            <DropdownItem>EUR</DropdownItem>
                            <DropdownItem>USD</DropdownItem>
                        </DropdownMenu>
                    </UncontrolledDropdown>
                    <UncontrolledDropdown size="sm" className="mr-auto">
                        <DropdownToggle caret>English</DropdownToggle>
                        <DropdownMenu>
                            <DropdownItem>English</DropdownItem>
                            <DropdownItem>Bulgarian</DropdownItem>
                            <DropdownItem>Russian</DropdownItem>
                        </DropdownMenu>
                    </UncontrolledDropdown>
                    <Button><FormattedMessage id='header.myAccount' className="justify-content-end"/></Button>
                    <Button><FormattedMessage id='header.wishList' className="justify-content-end"/></Button>
                    <Button><FormattedMessage id='header.checkout' className="justify-content-end"/></Button>

                    {/*<NavbarBrand href='/'><FormattedMessage id='app.react.start'/></NavbarBrand>*/}
                    {/*<Nav>*/}
                    {/*    <NavItem>*/}
                    {/*        <Button color="primary" onClick={() => props.history.push(routers.index())}><FormattedMessage*/}
                    {/*            id='app.home.title'/></Button>{` `}*/}
                    {/*        <Button color="primary" onClick={() => props.history.push(routers.state())}><FormattedMessage*/}
                    {/*            id='app.state.title'/></Button>{` `}*/}
                    {/*        <Button color="primary" onClick={() => props.history.push(routers.rest())}><FormattedMessage*/}
                    {/*            id='app.rest.title'/></Button>{` `}*/}
                    {/*        <Button color="primary" onClick={() => props.history.push(routers.webSocket())}><FormattedMessage*/}
                    {/*            id='app.webSocket.title'/></Button>{` `}*/}
                    {/*        <Button color="primary" onClick={() => props.history.push(routers.upload())}><FormattedMessage*/}
                    {/*            id='app.upload.title'/></Button>{` `}*/}
                    {/*    </NavItem>*/}
                    {/*</Nav>*/}
                    {/*<Nav className='ml-auto' navbar>*/}
                    {/*    <Locale/>*/}
                    {/*</Nav>*/}
                </div>
            </Navbar>
            <Navbar color='light' expand='lg'>
                <div className="container">
                    <FontAwesomeIcon icon={faDrumstickBite} size="lg" className="col-1"/>
                    <h2 className="mr-auto col-2"><FormattedMessage id='header2.logo'/></h2>
                    <Input type="select" name="select" id="exampleSelect" className="ml-auto justify-content-center col-2">
                        <option>All Type</option>
                        <option>Special</option>
                        <option>Only Best</option>
                        <option>Latest</option>
                    </Input>
                    <Input type="search" name="search" id="exampleSearch" placeholder="Search" className="justify-content-center col-4"/>
                    <h2 className="mr-auto col-3"><FormattedMessage id='header2.userInfo'/></h2>
                </div>
            </Navbar>
            <ApplicationRouter/>
        </div>
    );
}
