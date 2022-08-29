import React, { useEffect, useState, deleteRow } from "react";
import axios from "axios";
import "./washer.css";
//import './Cards.css';
import { toast } from "react-toastify";
import { useNavigate } from "react-router-dom";
const Washer = () => {
  const [washers, setWashers] = useState([]);
  let navigate = useNavigate();
  useEffect(() => {
    fetch("http://localhost:8081/order/allorders").then((result) => {
      result.json().then((resp) => {
        setWashers(resp);
      });
    });
  }, []);
  const handleClick = (event) => {
    event.currentTarget.disabled = true;

    console.log("button clicked");

    //   alert("Order Confirmed!!!");

    toast.success(
      "Order Confirmed ",
      {
        position: "top-center",

        autoClose: 2000,
      }
    );
  };
  return (
    <div>
      <div>
        {/* <h1 className="bookdetails">Booked Details</h1> */}

        <div className="backprevious" style={{ fontsize: "20px" }}>
          {" "}
          <a class="previous">&laquo;</a>
        </div>
        <h4
          style={{
            color: "red",
            backgroundColor: "powderblue",
            fontSize: "30px",
          }}
          className="text-center"
        >
          Booked Details
        </h4>
        <hr />
      </div>
      <div className="bookingContainer">
        {washers.map((emp, ind) => (
          <div className="bookings">
            <div>
              <p className="wash">Name : {emp.username}</p>
              <p className="wash">Car Name : {emp.carName}</p>
              <p className="wash">Car Model: {emp.carModel}</p>
              <p className="wash">Appointment Date : {emp.date}</p>
              {/* <p className="wash">Wash Pack price: {emp.cost}</p> */}
              <p className="wash">Contact.No : {emp.contactno}</p>
              <p className="wash">Address: {emp.address}</p>
              <button
                className=" bookBtn1 "
                class="btn btn-danger"
                style={{ marginleft: "5px " }}
                onClick={() => {
                  navigate(`/Order/${emp.orderId}`);
                }}
              >
                Cancel Order
              </button>
              &nbsp;
              {/* <button className=" bookBtn1 " class="btn btn-success" style={{marginleft:"5px " }} onClick={()=>{showToastMessage(); }}>Comfirm Order</button> */}
              <button
                className="btn btn-success"
                style={{ color: "white", borderRadius: "25px" }}
                onClick={handleClick}
              >
                Confirm Booking
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Washer;
