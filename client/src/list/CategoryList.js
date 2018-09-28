import React from 'react';

export class CategoryList extends React.Component{

    constructor(props){
        super(props);
        this.state = {
            findAll:[],
            isLoading:false
        }
    }

    componentDidMount(){
        this.setState({isLoading: true});
        fetch('http://localhost:8080/api/v1/categories')
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
                <h2>Category List</h2>
                {findAll.map((category) =>
                    <div key={category.id}>
                        {category.name}
                    </div>
                )}
            </div>
        )
    }

}

export default CategoryList;