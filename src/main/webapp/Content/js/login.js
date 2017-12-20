import "expose-loader?$!expose-loader?jQuery!jquery"
import React from "react"
import ReactDom from "react-dom"
import Login from "../component/Login"

$(function () {
    ReactDom.render(<Login />, document.getElementById("login"));

});
