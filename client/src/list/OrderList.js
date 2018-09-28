import React from 'react';

export class OrderList extends React.Component{

    constructor(props){
        super(props);

        this.state = {
            findAll:[],
            isLoading:false
        };
    }

    componentDidMount(){
        this.setState({isLoading: true});

        fetch('http://localhost:8080/api/v1/order')
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
                <h2>Order List</h2>
                {findAll.map((order) =>
                    <div key={order.id}>
                        {order.quantity}
                        {order.shipDate}
                        {order.status}
                        {order.complete}
                    </div>
                )}
            </div>
        )
    }

}

export default OrderList;