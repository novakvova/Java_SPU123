import { Outlet } from "react-router-dom";
import DefaultHeader from "./DefaultHeader";

const DefaultLayout = () => {
    return (
        <>
            <DefaultHeader />
            <div className="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4">
                {/* Сюди підставляється компонет один із групи комеонетів, які відносяться до даного Layout */}
                <Outlet/>
            </div>
        </>
    );
};

export default DefaultLayout;
