import { BrowserRouter, Switch, Route } from "react-router-dom";
import Footer from "./Footer";
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
            <Footer />
        </BrowserRouter>
    )
}

export default Routes;