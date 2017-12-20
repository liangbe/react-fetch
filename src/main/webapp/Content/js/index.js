import "expose-loader?$!expose-loader?jQuery!jquery"
import React from "react"
import ReactDom from "react-dom"
import Index from "../component/Index"

$(function () {
    ReactDom.render(<Index />, document.getElementById("app"));

});
