import React from "react"


export default class Index extends React.Component {
    constructor(props) {
        super(props);
        this.state={
            userName:""
        }
    }
    componentDidMount() {
        var _this=this;
        $.ajax({
            url: "/getSession",
            type: "GET",
            dataType: "json",
            error: function (data, status, e) {
                console.log(data);
            },
            success: function (data) {
                if(data.state){
                    sessionStorage.setItem("user", JSON.stringify(data.user));
                    _this.setState({userName:data.user.name});
                }else {
                    location.href = "/login";
                }

            }
        })
    }
    render(){
        return(
        <div >
            <h2>Welcome!  {this.state.userName},Login successfully!</h2>
        </div>

        );
    }
}