import React from 'react';

export class UserList extends React.Component{

    constructor(props){
        super(props);
        this.state = {
            findAll:[],
            isLoading:false
        }
        document.write("Constructor çalıştı <hr/>");
    }

    componentDidMount(){
        this.setState({isLoading: true});
        fetch('http://localhost:8080/api/v1/users')
            .then(response => response.json())
            .then(data => this.setState({findAll: data, isLoading: false}));
        document.write("Component Did Mount çalıştı <hr/>");
    }

    render(){
        const {findAll, isLoading} = this.state;
        if(isLoading){
            return <p>Loading...</p>;
        }
        return(
            <div>
                <h2>User List</h2>
                {findAll.map((user) =>
                    <div key={user.id}>
                        {user.username}
                        {user.firstname}
                        {user.lastname}
                        {user.email}
                        {user.password}
                        {user.phone}
                        {user.status}
                    </div>
                )}
            </div>
        )
    }

}

export default UserList;