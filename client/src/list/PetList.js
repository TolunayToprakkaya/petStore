import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import $ from 'jquery';

export class PetList extends React.Component{

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
        fetch('http://localhost:8080/api/v1/pets')
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
        var newPet = {id: this.state.id,
            name: this.state.name,
            photoUrl: this.state.photoUrl,
            status: this.state.status};
        this.createPet(newPet);
        window.location.reload();
    }

    createPet(pet) {
        fetch('http://localhost:8080/api/v1/pets', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(pet)
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
        $('#name').val(key.name);
        $('#photoUrl').val(key.photoUrl);
        $('#status').val(key.status);

        //alert($(".table-striped tbody").find("tr").eq(_tr).html());


        $("#saveBtn").click(function (event) {
            key.id=$('#id').val();
            key.name=$('#name').val();
            key.photoUrl=$('#photoUrl').val();
            key.status=$('#status').val();

            event.stopPropagation();
            console.log('pet ::', key);
            fetch('http://localhost:8080/api/v1/pets/'+key.id , {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(key)
            });
            window.location.reload();
        });
    }

    deletePet(id) {
        console.log('id ::', id);

        $("#deleteBtn").click(function (event) {
            event.stopPropagation();
            fetch('http://localhost:8080/api/v1/pets/'+id , {
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

        var cardStyle = {
          width: 18+'rem',
          marginBottom: 10+'px'
        };
        var searchStyle = {
            width: 250+'px',
            float: 'right'
        }

        return(
            <div className={"container-fluid"}>
                <div className={"row"}>
                    <div className={"col-md-12"}>
                        <nav className="navbar navbar-expand-lg navbar-white bg-white">
                            <div className="collapse navbar-collapse" id="navbarSupportedContent">
                                <ul className="navbar-nav mr-auto">
                                    <li className="nav-item">
                                        <button type="button" className="btn btn-success" data-toggle="modal" data-target="#addModal"><FontAwesomeIcon icon="plus"/> Add</button>
                                    </li>
                                </ul>
                                <form className="form-inline my-2 my-lg-0">
                                    <input className="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"/>
                                    <button className="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                                </form>
                            </div>
                        </nav>
                        <div className={"row"}>
                            {findAll.map((pet) =>
                                <div className={"col-md-2 d-flex align-items-stretch"} key={pet.id}>
                                    <div className="card" style={cardStyle}>
                                        <img className="card-img-top" src={pet.photoUrl} alt="Card image cap"/>
                                        <div className="card-body">
                                            <h5 className="card-title">{pet.name}</h5>
                                            <p className="card-text">{pet.status}</p>
                                            <button type="button" className="btn btn-primary" onClick={this.handleUpdate.bind(this, pet.id)} data-toggle="modal" data-target="#updateModal"><FontAwesomeIcon icon="edit"/> Edit</button>
                                            &nbsp;<button type="button" className="btn btn-danger" onClick={this.deletePet.bind(this, pet.id)} data-toggle="modal" data-target="#deleteModal"><FontAwesomeIcon icon="trash"/> Delete</button>
                                        </div>
                                    </div>
                                </div>
                            )}
                        </div>
                    </div>
                </div>


                <div className="modal fade" id="addModal" tabIndex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div className="modal-dialog" role="document">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title" id="exampleModalLabel">Add Pet</h5>
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
                                            <input type="text" className="form-control" placeholder="name" name="name"
                                                   onChange={this.handleChange}/>
                                        </div>
                                    </div>
                                    <div className={"form-group"}>
                                        <div className="col-md-12">
                                            <input type="text" className="form-control" placeholder="photoUrl" name="photoUrl"
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
                                <h5 className="modal-title" id="exampleModalLabel">Edit Pet</h5>
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
                                            <input type="text" className="form-control" placeholder="name" name="name" id="name"/>
                                        </div>
                                    </div>
                                    <div className={"form-group"}>
                                        <div className="col-md-12">
                                            <input type="text" className="form-control" placeholder="photoUrl" name="photoUrl" id="photoUrl"/>
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
                                <button className="btn btn-success" type='button' onClick={this.updatePet} id={"saveBtn"}><FontAwesomeIcon icon="save"/> Save</button>
                            </div>
                        </div>
                    </div>
                </div>


                <div className="modal fade" id="deleteModal" tabIndex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div className="modal-dialog" role="document">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title" id="exampleModalLabel">Delete Pet</h5>
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

export default PetList;