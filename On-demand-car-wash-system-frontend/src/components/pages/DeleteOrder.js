import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router';
import { useNavigate } from 'react-router-dom';
import { Link } from "react-router-dom";
// import { baseUrl } from '../util/AppConstants';
function DeleteOrder() {
    const [order, setOrder] = useState(null)
    const { id } = useParams();
    const navigate = useNavigate();
    const fetchOrderById = () => {
        axios.get("http://localhost:8081/order/viewOrder/"+id).then(resp => setOrder(resp.data))
    }
    useEffect(fetchOrderById);
    const deleteOrder = () => {
        axios.delete("http://localhost:8081/order/delete/" + id).then(resp => {
            alert(resp.data);
           
        })
      


    }
    return (
        <div>
            {/* <h1 className="bookdetails">Order Details</h1> */}

            {/* <div className="backprevious" style={{fontsize:"20px"}}> <a class="previous">&laquo;</a> */}


            <h4  style={{ color: "red", backgroundColor:"powderblue", fontSize:"30px"}} className = "text-center">Order Details</h4>
<hr/>




            {
                order !== null &&
                <div className="booking">
                    
                    <p className="wash"> Order ID : {order.orderId}</p>
                    <p className="wash"> CARNAME : {order.carModel}</p>
                    <p className="wash"> USERNAME : {order.username}</p>
                    <p className="wash"> DATE : {order.date}</p>
                    <p className="wash"> CONTACT : {order.contactno}</p>
                    <p className="wash"> ADDRESS : {order.address}</p>
                
                </div>
            }
            <div><button className=" bookBtn1 "style={{marginleft:"5px " }} onClick={() => {deleteOrder();navigate("/washer"); }}>Delete</button>
                  </div>
        </div>
    )
}
export default DeleteOrder;