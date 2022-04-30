import React, { Component } from 'react';
import './App.css';
import DashBoards from './components/DashBoards';
import Header from "./components/Layout/Header";
import "bootstrap/dist/css/bootstrap.min.css";
import {BrowserRouter as Router ,Routes, Route} from "react-router-dom";
import AddProject from './components/Project/AddProject';


class App extends Component{
  render() {
return (
  
  
    <div className="App">
    
    <Router>
    <Header />
    
    <Routes>
    <Route path="/dashboard.html" element={<DashBoards />} />
    <Route path="/dashboard" element={<DashBoards />} />
    <Route exact path="/addProject" element={<AddProject />} />
    
   
    </Routes>
    </Router>
    </div>


    
    
  );
}
}

export default App;
