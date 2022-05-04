import React, { Component } from 'react';
import './App.css';
import DashBoards from './components/DashBoards';
import Header from "./components/Layout/Header";
import "bootstrap/dist/css/bootstrap.min.css";
import {BrowserRouter as Router ,Routes, Route} from "react-router-dom";
import AddProject from './components/Project/AddProject';
import { Provider } from "react-redux";
import store from "./store";



class App extends Component{
  render() {
return (
  
  <Provider store={store}>
        <Router>
          <div className="App">
            <Header />
            <Route exact path="/dashboard" component={DashBoards} />
            <Route exact path="/addProject" component={AddProject} />
          </div>
        </Router>
      </Provider>
 


    
    
  );
}
}

export default App;
