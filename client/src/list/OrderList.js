import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import $ from 'jquery';

export class OrderList extends React.Component{

    constructor(props){
        super(props);
        this.state = {
            error: null,
            findAll:[],
            isLoading:false,
            value: ''
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);

        this.handleUpdate = this.handleUpdate.bind(this);
    }

    componentDidMount(){
        this.setState({isLoading: true});
        fetch('http://localhost:8080/api/v1/order')
            .then(response => response.json())
            .then(data => this.setState({findAll: data, isLoading: false}));
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
        var newOrder = {id: this.state.id,
            quantity: this.state.quantity,
            shipDate: this.state.shipDate,
            status: this.state.status,
            complete: this.state.complete};
        this.createOrder(newOrder);
        window.location.reload();
    }

    createOrder(order) {
        fetch('http://localhost:8080/api/v1/order', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(order)
        })
    }

    handleUpdate(id) {
        var key;
        //var _tr=-1;
        for(var ii=0;ii<this.state.findAll.length;ii++) {
            if(this.state.findAll[ii].id === id) {
                key = this.state.findAll[ii];
                //_tr=ii;
                break;
            }
        }
        //alert(key.username);
        $('#id').val(key.id);
        $('#quantity').val(key.quantity);
        $('#shipDate').val(key.shipDate);
        $('#status').val(key.status);
        $('#complete').val(key.complete);

        //alert($(".table-striped tbody").find("tr").eq(_tr).html());


        $("#saveBtn").click(function (event) {
            key.id=$('#id').val();
            key.quantity=$('#quantity').val();
            key.shipDate=$('#shipDate').val();
            key.status=$('#status').val();
            key.complete=$('#complete').val();

            event.stopPropagation();
            console.log('order ::', key);
            fetch('http://localhost:8080/api/v1/order/'+key.id , {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(key)
            });
            window.location.reload();
        });
    }

    deleteOrder(id) {
        console.log('id ::', id);

        $("#deleteBtn").click(function (event) {
            event.stopPropagation();
            fetch('http://localhost:8080/api/v1/order/'+id , {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(id)
            });
            window.location.reload();
        });

    }

    render(){
        const {findAll, isLoading} = this.state;
        if(isLoading){
            return <p>Loading...</p>;
        }

        return(
            <div>
                <table className="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">ShipDate</th>
                        <th scope="col">Status</th>
                        <th scope="col">Action</th>
                        <th scope="col"><button type="button" className="btn btn-success" data-toggle="modal" data-target="#addModal"><FontAwesomeIcon icon="plus"/> Add</button></th>
                    </tr>
                    </thead>
                    <tbody>
                    {findAll.map((order) =>
                        <tr key={order.id}>
                            <td>{order.id}</td>
                            <td id="txt_input">{order.quantity}</td>
                            <td>{order.shipDate}</td>
                            <td>{order.status}</td>
                            <td><button type="button" className="btn btn-primary" onClick={this.handleUpdate.bind(this, order.id)} data-toggle="modal" data-target="#updateModal"><FontAwesomeIcon icon="edit"/> Edit</button>
                                &nbsp;<button type="button" className="btn btn-danger" onClick={this.deleteOrder.bind(this, order.id)} data-toggle="modal" data-target="#deleteModal"><FontAwesomeIcon icon="trash"/> Delete</button></td>
                            <td></td>
                        </tr>
                    )}
                    </tbody>
                </table>

                <div className="modal fade" id="addModal" tabIndex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div className="modal-dialog" role="document">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title" id="exampleModalLabel">Add Order</h5>
                                <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div className="modal-body">
                                <form>
                                    <div className={"form-group"}>
                                        <div className="col-md-12">
                                            <input type="text" className="form-control" placeholder="id" name="id"
                                                   onChange={this.handleChange}/>
                                        </div>
                                    </div>
                                    <div className={"form-group"}>
                                        <div className="col-md-12">
                                            <input type="text" className="form-control" placeholder="quantity" name="quantity"
                                                   onChange={this.handleChange}/>
                                        </div>
                                    </div>
                                    <div className={"form-group"}>
                                        <div className="col-md-12">
                                            <input type="text" className="form-control" placeholder="shipDate" name="shipDate"
                                                   onChange={this.handleChange}/>
                                        </div>
                                    </div>
                                    <div className={"form-group"}>
                                        <div className="col-md-12">
                                            <input type="text" className="form-control" placeholder="status" name="status"
                                                   onChange={this.handleChange}/>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-secondary" data-dismiss="modal"><FontAwesomeIcon icon="times-circle"/> Close</button>
                                <button className="btn btn-success" onClick={this.handleSubmit}><FontAwesomeIcon icon="save"/> Save</button>
                            </div>
                        </div>
                    </div>
                </div>



                <div className="modal fade" id="updateModal" tabIndex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div className="modal-dialog" role="document">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title" id="exampleModalLabel">Edit Order</h5>
                                <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div className="modal-body">
                                <form>
                                    <div className={"form-group"}>
                                        <div className="col-md-12">
                                            <input type="text" className="form-control" placeholder="id" name="id" id="id" disabled/>
                                        </div>
                                    </div>
                                    <div className={"form-group"}>
                                        <div className="col-md-12">
                                            <input type="text" className="form-control" placeholder="quantity" name="quantity" id="quantity"/>
                                        </div>
                                    </div>
                                    <div className={"form-group"}>
                                        <div className="col-md-12">
                                            <input type="text" className="form-control" placeholder="shipDate" name="shipDate" id="shipDate"/>
                                        </div>
                                    </div>
                                    <div className={"form-group"}>
                                        <div className="col-md-12">
                                            <input type="text" className="form-control" placeholder="status" name="status" id="status"/>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-secondary" data-dismiss="modal"><FontAwesomeIcon icon="times-circle"/> Close</button>
                                <button className="btn btn-success" type='button' onClick={this.updateOrder} id={"saveBtn"}><FontAwesomeIcon icon="save"/> Save</button>
                            </div>
                        </div>
                    </div>
                </div>


                <div className="modal fade" id="deleteModal" tabIndex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div className="modal-dialog" role="document">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title" id="exampleModalLabel">Delete Order</h5>
                                <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div className="modal-body">
                                Are You Sure?
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-secondary" data-dismiss="modal"><FontAwesomeIcon icon="times-circle"/> Close</button>
                                <button type="button" className="btn btn-primary" id={"deleteBtn"}><FontAwesomeIcon icon="trash"/> Delete</button>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
        )
    }

}

export default OrderList;