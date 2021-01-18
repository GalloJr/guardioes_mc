import { BrowserRouter, Switch, Route } from "react-router-dom";
import Home from "./Home";
import Members from "./Members";
import Navbar from "./Navbar";

function Routes() {
    return (
        <BrowserRouter>
            <Navbar />
            <Switch>
                <Route path="/members">
                    <Members />
                </Route>
                <Route path="/">
                    <Home />
                </Route>
            </Switch>
        </BrowserRouter>
    )
}

export default Routes;