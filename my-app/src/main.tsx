import ReactDOM from 'react-dom/client'
import App from './App.tsx'
import './index.css'
import {BrowserRouter} from "react-router-dom";
import 'flowbite';
import {Provider} from "react-redux";
import {store} from "./store";
import http_common from "./http_common.ts";
import jwtDecode from "jwt-decode";
import {AuthUserActionType, IUser} from "./entities/Auth.ts";

if(localStorage.token) {
    const {token} = localStorage;
    http_common.defaults.headers.common["Authorization"]=`Bearer ${token}`;
    const user = jwtDecode(token) as IUser;
    store.dispatch({
        type: AuthUserActionType.LOGIN_USER,
        payload: {
            sub: user.sub,
            email: user.email,
            roles: user.roles
        }
    });
}

ReactDOM.createRoot(document.getElementById('root')!).render(
    <Provider store={store}>
        <BrowserRouter>
            <App/>
        </BrowserRouter>,
    </Provider>
)
