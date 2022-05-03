import React, { Component } from 'react';
import './App.css';
import DashBoards from './components/DashBoards';
import Header from "./components/Layout/Header";
import "bootstrap/dist/css/bootstrap.min.css";
import {BrowserRouter as Router ,Routes, Route, BrowserRouter} from "react-router-dom";
import AddProject from './components/Project/AddProject';
import { Provider } from "react-redux";
import store from "./store";

import history from "./history";

class App extends Component{
  render() {
return (
  
  <Provider store={store}>
  <Router history={history}>
    <div className="App">
    
    
    <Header />
    
    <Routes>
    <Route exact path="/" component={DashBoards} />
    <Route path="/dashboard.html" element={<DashBoards />} />
    <Route path="/dashboard" element={<DashBoards />} />
    <Route exact path="/addProject" element={<AddProject />} />
    
   
    </Routes>
    
    
    </div>
    </Router>
    </Provider>
 


    
    
  );
}
}

export default App;
