import React from 'react'
import { Link } from 'react-router-dom'
import "./Welcome.css"
function Welcome() {
  return (
    <div>
    <div class="intro-header">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="intro-message">   
                        <h1 class="animated bounceInDown">Welcome to Todo App</h1>                       
                        <ul class="list-inline intro-social-buttons" id="headerButton">
                            <li>
                            <Link to="/get">
                            <button href="#"  id="button" class="animated bounceInUp btn btn-info btn-lg"> <span class="network-name">START RIGHT HERE</span></button>
                            </Link>
                            </li>         
                        </ul>
                      <div id="empty"> </div>
                    </div>
                </div>
            </div>
        </div>
  </div>
    </div>
  )
}

export default Welcome