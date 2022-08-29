import React, { useEffect, useState } from "react";
 import Footer from "./Footer";
import axios from "axios";
import AdminNab from "./AdminNab";

export default function Profile() {
  const [messages, setMessages] = useState([]);

  const fetchAll = () => {
    axios

      .get("http://localhost:8083/user/allusers")

      .then((resp) => setMessages(resp.data));
  };

  useEffect(fetchAll, []);
  return (
    <div style={{ backgroundColor: "" }}>
      <div>
        <div className="container-fluid" style={{ backgroundColor: "" }}>
          <AdminNab />

          <div className="mrginprvmsg">
        
          </div>

          <h4
            style={{
              color: "Black",

              backgroundColor: "DeepSkyBlue",

              fontSize: "30px",
            }}
            className="text-center"
          >
            USER LIST
          </h4>

          <table class="table table-bordered" style={{ backgroundColor: "" }}>
            <thead class="thead-dark">
              <tr>
                <th>Name</th>

                <th>Username</th>

                <th>Email</th>

                <th>Contact</th>

                {/* <th colSpan={2}>Actions</th> */}
              </tr>
            </thead>

            <tbody>
              {messages.map((u, index) => (
                <tr key={index + 1}>
                  {/* <td>{index+1}</td> */}

                  <td>{u.name}</td>

                  <td>{u.username}</td>

                  <td>{u.email}</td>

                  <td>{u.contactno}</td>

                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
      <div>
      <Footer />
         </div>
    </div>
  );
}
