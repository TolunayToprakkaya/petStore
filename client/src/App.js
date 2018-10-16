import React, { Component } from 'react';
import{
    Route,
    HashRouter
}from "react-router-dom";

import {Header} from "./inc/header";
import {Footer} from "./inc/footer";
import {UserList} from "./list/UserList";
import {PetList} from "./list/PetList";
import {CategoryList} from "./list/CategoryList";
import {TagList} from "./list/TagList";
import {OrderList} from "./list/OrderList";

import {library} from "@fortawesome/fontawesome-svg-core";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {faPlus, faTrash, faEdit, faSave, faTimesCircle, faShoppingCart} from "@fortawesome/free-solid-svg-icons";
library.add(faPlus, faTrash, faEdit, faSave, faTimesCircle, faShoppingCart);

class App extends Component {
    constructor(props){
        super(props);
    }
  render() {
    return (
        <HashRouter>
            <div>
                <Header/>
                <div className="content">
                    <Route path="/userList" component={UserList}/>
                    <Route path="/petList" component={PetList}/>
                    <Route path="/categoryList" component={CategoryList}/>
                    <Route path="/tagList" component={TagList}/>
                    <Route path="/orderList" component={OrderList}/>
                </div>
                <Footer/>
            </div>
        </HashRouter>
    );
  }
}
export default App;

/*
        <div className={"content"}>
            <Header/>
            <UserList/>
            <PetList/>
            <Footer/>
        </div>


import{
    Route,
    HashRouter
}from "react-router-dom";

<HashRouter>
        <Header/>
            <div className={"content"}>
                <Route exact path="/" component={UserList}/>
                <Route path="/petList" component={PetList}/>
            </div>
            <Footer/>
        </HashRouter>
 */