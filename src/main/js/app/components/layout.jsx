import React, {useState} from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import {
    Button,
    Nav, Navbar, NavbarBrand, NavItem, NavLink,
    Dropdown, DropdownToggle, DropdownMenu, DropdownItem, UncontrolledDropdown,
    FormGroup, Input
} from 'reactstrap';
import Locale from 'app/components/locale';
import {FormattedMessage} from 'react-intl';

import {FontAwesomeIcon} from '@fortawesome/react-fontawesome'
import {faPhone, faDrumstickBite, faShoppingCart} from '@fortawesome/free-solid-svg-icons'
import 'app/css/header.css'

import * as routers from 'app/constants/routes'
import ApplicationRouter from 'app/router/routerSwitch';

export default function IndexLayout(props) {

    return (
        <div>
            <Navbar color='secondary' expand='lg'>
                <div className="container">
                    <FontAwesomeIcon icon={faPhone}/>
                    <FormattedMessage id='header.callUs'/>
                    <FormattedMessage id='header.phone'/>
                    <UncontrolledDropdown size="sm">
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
                    <div className="row align-items-center w-100">
                        <div id="logoDiv" className="col-2 justify-content-start">
                            <FontAwesomeIcon icon={faDrumstickBite} className="logo" size="2x"/>
                            <h2 className="logo"><FormattedMessage id='header2.logo'/></h2>
                        </div>
                        <div id="searchDiv" className="ml-auto justify-content-center col-7 input-group w-100 row">
                            <Input type="select" name="select" id="exampleSelect" className="col-3 custom-select">
                                <option>All Type</option>
                                <option>Special</option>
                                <option>Only Best</option>
                                <option>Latest</option>
                            </Input>
                            <Input type="search" name="search" id="exampleSearch" placeholder="Search"
                                   className="justify-content-center col-7"/>
                        </div>
                        <div id="userDiv" className="justify-content-end col-3">
                            <div id="signInRegister" className="logo col-8">
                                <small className="justify-content-center text-muted col-8">Welcome guest!</small>
                                <div id="userButtonsDiv">
                                    <a href="#" className="logo col-7"><FormattedMessage id='header2.signIn' className="justify-content-end"/></a>
                                    <a href="#" className="logo col-5"><FormattedMessage id='header2.register' className="justify-content-end"/></a>
                                </div>
                            </div>
                            <div id="cartDiv" className="logo col-4">
                                <a href="#">
                                    <div className="rounded-circle rounded-lg border icontext">
                                        <FontAwesomeIcon icon={faShoppingCart} className="" size="2x"/>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </Navbar>
            <ApplicationRouter/>
        </div>
    );
}
