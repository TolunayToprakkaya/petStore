import React from 'react';

export class Header extends React.Component{
    render(){
        return(
            <nav className={"navbar navbar-expand-lg navbar-dark bg-dark"}>
                <div className={"collapse navbar-collapse"} id="navbarNav">
                    <ul className={"navbar-nav"}>
                        <li className={"nav-item"}>
                            <a className={"nav-link"} href="#">User</a>
                        </li>
                        <li className={"nav-item"}>
                            <a className={"nav-link"} href="#">Pet</a>
                        </li>
                        <li className={"nav-item"}>
                            <a className={"nav-link"} href="#">Category</a>
                        </li>
                        <li className={"nav-item"}>
                            <a className={"nav-link"} href="#">Tag</a>
                        </li>
                        <li className={"nav-item"}>
                            <a className={"nav-link"} href="#">Order</a>
                        </li>
                    </ul>
                </div>
            </nav>
        )
    }
}

export default Header;