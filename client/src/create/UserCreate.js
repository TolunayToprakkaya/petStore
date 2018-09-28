/*
import React from 'react';

export class UserCreate extends React.Component {
    constructor(props){
        super(props);
        this.state = {value: ''};
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        console.log("NAME: " + event.target.name + " VALUE: " + event.target.value)
        this.setState(
            {
                [event.target.name]: event.target.value
            }
        );
    }

    handleSubmit(event) {
        event.preventDefault();
        var newUser = {id: this.state.id,
            username: this.state.username,
            firstname: this.state.firstname,
            lastname: this.state.lastname,
            email: this.state.email,
            password: this.state.password,
            phone: this.state.phone,
            status: this.state.status};
        this.createUser(newUser);
        window.location.reload();
    }


    createUser(user) {
        fetch('http://localhost:8080/api/v1/users', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(user)
        })
    }


    render() {
        return (
            <div className="App-header">
                <div className="card">
                    <div className="card-header">Create student</div>
                    <div className="card-body">
                        <form>
                            <div className={"form-group"}>
                                <div className="col-md-2">
                                    <input type="text" className="form-control" placeholder="id" name="id"
                                           onChange={this.handleChange}/>
                                </div>
                            </div>
                            <div className={"form-group"}>
                                <div className="col-md-2">
                                    <input type="text" className="form-control" placeholder="username" name="username"
                                           onChange={this.handleChange}/>
                                </div>
                            </div>
                            <div className={"form-group"}>
                                <div className="col-md-2">
                                    <input type="text" className="form-control" placeholder="firstname" name="firstname"
                                           onChange={this.handleChange}/>
                                </div>
                            </div>
                            <div className={"form-group"}>
                                <div className="col-md-2">
                                    <input type="text" className="form-control" placeholder="lastname" name="lastname"
                                           onChange={this.handleChange}/>
                                </div>
                            </div>
                            <div className={"form-group"}>
                                <div className="col-md-2">
                                    <input type="text" className="form-control" placeholder="email" name="email"
                                           onChange={this.handleChange}/>
                                </div>
                            </div>
                            <div className={"form-group"}>
                                <div className="col-md-2">
                                    <input type="text" className="form-control" placeholder="password" name="password"
                                           onChange={this.handleChange}/>
                                </div>
                            </div>
                            <div className={"form-group"}>
                                <div className="col-md-2">
                                    <input type="text" className="form-control" placeholder="phone" name="phone"
                                           onChange={this.handleChange}/>
                                </div>
                            </div>
                            <div className={"form-group"}>
                                <div className="col-md-2">
                                    <input type="text" className="form-control" placeholder="status" name="status"
                                           onChange={this.handleChange}/>
                                </div>
                            </div>
                            <div className={"form-group"}>
                                <div className="col-md-2">
                                    <button className="btn btn-success" onClick={this.handleSubmit}>Save</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        );
    }
}

export default UserCreate;
*/