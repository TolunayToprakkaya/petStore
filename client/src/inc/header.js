/*
import React from 'react';

export class Header extends React.Component{
    render(){
        return(
            <nav className={"navbar navbar-expand-lg navbar-dark bg-dark"}>
                <div className={"collapse navbar-collapse"} id="navbarNav">
                    <ul className={"navbar-nav"}>
                        <li className={"nav-item"}>
                            <a className={"nav-link"} href="UserList">User</a>
                        </li>
                        <li className={"nav-item"}>
                            <a className={"nav-link"} href="PetList">Pet</a>
                        </li>
                        <li className={"nav-item"}>
                            <a className={"nav-link"} href="CategoryList">Category</a>
                        </li>
                        <li className={"nav-item"}>
                            <a className={"nav-link"} href="TagList">Tag</a>
                        </li>
                        <li className={"nav-item"}>
                            <a className={"nav-link"} href="OrderList">Order</a>
                        </li>
                    </ul>
                </div>
            </nav>
        )
    }
}

export default Header;
*/
import React from 'react';
import{
    NavLink
}from 'react-router-dom';

export class Header extends React.Component{

    render(){
        return(
            <nav className={"navbar navbar-expand-lg navbar-dark bg-dark"}>
                <div className={"collapse navbar-collapse"} id="navbarNav">
                    <ul className={"navbar-nav"}>
                        <li className={"nav-item"}>
                            <NavLink to="/userList" className={"nav-link"} >User</NavLink>
                        </li>
                        <li className={"nav-item"}>
                            <NavLink to="/petList" className={"nav-link"} >Pet</NavLink>
                        </li>
                        <li className={"nav-item"}>
                            <NavLink to="/categoryList" className={"nav-link"} >Category</NavLink>
                        </li>
                        <li className={"nav-item"}>
                            <NavLink to="/tagList" className={"nav-link"} >Tag</NavLink>
                        </li>
                        <li className={"nav-item"}>
                            <NavLink to="/orderList" className={"nav-link"} >Order</NavLink>
                        </li>
                    </ul>
                </div>
            </nav>
        )
    }
}

export default Header;
