import React from 'react';
import {BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import DogsView from './Components/DogsView';
import CatsView from './Components/CatsView';
import {Nav} from "react-bootstrap";
import "./App.css";

function App() {
  return (
      <div>
          <Nav justify variant="tabs" defaultActiveKey="/dogs" className={"nav"}>
              <Nav.Item>
                  <Nav.Link eventKey="1" href="dogs">Dogs</Nav.Link>
              </Nav.Item>
              <Nav.Item>
                  <Nav.Link eventKey="2" href="cats">Cats</Nav.Link>
              </Nav.Item>
          </Nav>
      <Router>
          <div>
              <Routes>
              <Route path="/dogs" Component={DogsView}/>
              <Route path="/cats" Component={CatsView}/>
              <Route path="/" element={<DogsView />} />
              </Routes>
          </div>
      </Router>
      </div>
  );
}

export default App;