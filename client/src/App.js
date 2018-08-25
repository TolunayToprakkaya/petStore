import React, { Component } from 'react';
import {Header} from "./inc/header";
import {Footer} from "./inc/footer";
import {UserList} from "./inc/UserList";

class App extends Component {
    constructor(props){
        super(props);
    }
  render() {
    return (
        <div className={"content"}>
            <Header/>
            <UserList/>
            <Footer/>
        </div>
    );
  }
}
export default App;
