import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import $ from 'jquery';

export class TagList extends React.Component{

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
        fetch('http://localhost:8080/api/v1/tags')
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
        var newTag = {name: this.state.name};
        this.createTag(newTag);
        window.location.reload();
    }

    createTag(tag) {
        fetch('http://localhost:8080/api/v1/tags', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(tag)
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

        //alert($(".table-striped tbody").find("tr").eq(_tr).html());


        $("#saveBtn").click(function (event) {
            key.id=$('#id').val();
            key.name=$('#name').val();

            event.stopPropagation();
            console.log('user ::', key);
            fetch('http://localhost:8080/api/v1/tags/'+key.id , {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(key)
            });
            window.location.reload();
        });
    }

    deleteTag(id) {
        console.log('id ::', id);

        $("#deleteBtn").click(function (event) {
            event.stopPropagation();
            fetch('http://localhost:8080/api/v1/tags/'+id , {
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
                        <th scope="col">Name</th>
                        <th scope="col">Action</th>
                        <th scope="col"><button type="button" className="btn btn-success" data-toggle="modal" data-target="#addModal"><FontAwesomeIcon icon="plus"/> Add</button></th>
                    </tr>
                    </thead>
                    <tbody>
                    {findAll.map((tag) =>
                        <tr key={tag.id}>
                            <td>{tag.id}</td>
                            <td id="txt_input">{tag.name}</td>
                            <td><button type="button" className="btn btn-primary" onClick={this.handleUpdate.bind(this, tag.id)} data-toggle="modal" data-target="#updateModal"><FontAwesomeIcon icon="edit"/> Edit</button>
                                &nbsp;<button type="button" className="btn btn-danger" onClick={this.deleteTag.bind(this, tag.id)} data-toggle="modal" data-target="#deleteModal"><FontAwesomeIcon icon="trash"/> Delete</button></td>
                            <td></td>
                        </tr>
                    )}
                    </tbody>
                </table>

                <div className="modal fade" id="addModal" tabIndex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div className="modal-dialog" role="document">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title" id="exampleModalLabel">Add Tag</h5>
                                <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div className="modal-body">
                                <form>
                                    <div className={"form-group"}>
                                        <div className="col-md-12">
                                            <input type="text" className="form-control" placeholder="name" name="name"
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
                                <h5 className="modal-title" id="exampleModalLabel">Edit Tag</h5>
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
                                </form>
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-secondary" data-dismiss="modal"><FontAwesomeIcon icon="times-circle"/> Close</button>
                                <button className="btn btn-success" type='button' onClick={this.updateTag} id={"saveBtn"}><FontAwesomeIcon icon="save"/> Save</button>
                            </div>
                        </div>
                    </div>
                </div>


                <div className="modal fade" id="deleteModal" tabIndex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div className="modal-dialog" role="document">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title" id="exampleModalLabel">Delete Tag</h5>
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

export default TagList;