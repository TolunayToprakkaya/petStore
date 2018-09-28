import React from 'react';

export class PetList extends React.Component{

    constructor(props){
        super(props);
        this.state = {
            findAll:[],
            isLoading:false
        }
    }

    componentDidMount(){
        this.setState({isLoading: true});
        fetch('http://localhost:8080/api/v1/pets')
            .then(response => response.json())
            .then(data => this.setState({findAll: data, isLoading: false}));
    }

    render(){
        const {findAll, isLoading} = this.state;
        if(isLoading){
            return <p>Loading...</p>;
        }
        return(
            <div>
                <h2>Pet List</h2>
                {findAll.map((pet) =>
                    <div key={pet.id}>
                        {pet.name}
                        {pet.photoUrl}
                        {pet.status}
                    </div>
                )}
            </div>
        )
    }

}

export default PetList;