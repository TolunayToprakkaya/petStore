/*
import React from 'react';

export class UserDelete extends React.Component {

    deleteUser(id) {
        console.log('id ::', id);
        fetch('http://localhost:8080/api/v1/users/'+id , {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(id)
        });
        window.location.reload();
    }

    render() {
        return (
            <div className="App-header">
                <div className="modal fade" id="exampleModal" tabIndex={"-1"} role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div className="modal-dialog" role="document">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title" id="exampleModalLabel">Kullanıcı Sil</h5>
                                <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div className="modal-body">
                                Emin Misin?
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-secondary" data-dismiss="modal">İptal</button>
                                <button type="button" className="btn btn-primary" onClick={this.deleteUser.bind(this, user.id)}>Evet</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default UserDelete;
*/