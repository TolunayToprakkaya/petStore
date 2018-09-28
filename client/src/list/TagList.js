import React from 'react';

export class TagList extends React.Component{

    constructor(props){
        super(props);
        this.state = {
            findAll:[],
            isLoading:false
        }
    }

    componentDidMount(){
        this.setState({isLoading: true});
        fetch('http://localhost:8080/api/v1/tags')
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
                <h2>Tag List</h2>
                {findAll.map((tag) =>
                    <div key={tag.id}>
                        {tag.name}
                    </div>
                )}
            </div>
        )
    }

}

export default TagList;