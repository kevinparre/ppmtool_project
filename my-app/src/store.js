import { configureStore } from '@reduxjs/toolkit'


import rootReducer from "./reducers/index";

let store;

if (window.navigator.userAgent.includes("Chrome")) {
  store = configureStore({
    reducer:rootReducer
    }
    );
  
} else {
  store = configureStore({
    reducer:rootReducer
  }
  );
}

export default store;