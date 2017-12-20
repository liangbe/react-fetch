import React from "react"


export default class Login extends React.Component {
    constructor(props) {
        super(props);
        this.state ={
            userName: "",
            password: "",
        }
    }

    handleSubmit(){
        if (this.state.userName.length == "" || this.state.password.length == "") {
            alert("请输入用户名/密码");
            return false;
        }

        $.ajax({
            url: "/doLogin",
            data: {"username": this.state.userName, "password": this.state.password},
            type: "POST",
            dataType: "json",
            error: function (data, status, e) {
                console.log(data);
            },
            success: function (data) {
                console.log(data);
                location.href = "/index";
            }
        })
    }

    render(){
        return(
        <div >
            <form>
                <div >
                    <span className="input-group-addon addon-login">User Name</span>
                    <input type="text" placeholder="用户名" value={this.state.userName} onChange={ev => this.setState({userName:ev.target.value})}/>
                </div>
                <div >

                        <span >Password</span>
                        <input type="password"  placeholder="密码" value={this.state.password} onChange={ev => this.setState({password:ev.target.value})}/>
                </div>
            </form>
            <button  onClick={ev => this.handleSubmit()}>登&nbsp;&nbsp;录</button>
        </div>

        );
    }
}