import { Sidebar, Footer } from './components';
import { Routes, Route, BrowserRouter } from 'react-router-dom';
// import { Passwords, Main, Calculator } from './pages';
import { Passwords, Main } from './pages';

import { useState, createContext } from 'react';
import React from 'react';
import Calculator from './pages/Calculator';
import Times from './pages/Time';
import Weather from './pages/Weather';
import Currency from './pages/Currency';
import Events from './pages/Events';

export const SidebarContext = createContext<
    [boolean, React.Dispatch<React.SetStateAction<boolean>>]
>([true, () => {}]);
export const ModalContext = createContext<
    [JSX.Element, React.Dispatch<React.SetStateAction<JSX.Element>>]
>([<></>, () => {}]);

const App = () => {
    const [sidebarOpen, setSidebarOpen] = useState(true);

    return (
        <>
            <SidebarContext.Provider value={[sidebarOpen, setSidebarOpen]}>
                <div className='flex h-screen w-screen'>
                    <BrowserRouter>
                        <Sidebar />

                        <div
                            className={`${
                                sidebarOpen ? 'md:pl-72' : 'md:pl-[5.5rem]'
                            } transition-all duration-300 w-full overflow-x-hidden`}
                        >
                            <div className='overflow-y-auto'>
                                <Routes>
                                    <Route path='/' element={<Main />} />
                                    <Route
                                        path='/passwords'
                                        element={<Passwords />}
                                    />
                                    <Route
                                        path='/calc'
                                        element={<Calculator />}
                                    />
                                    <Route path='/time' element={<Times />} />
                                    <Route
                                        path='/weather'
                                        element={<Weather />}
                                    />
                                    <Route
                                        path='/currency'
                                        element={<Currency />}
                                    />
                                    <Route
                                        path='/calendar'
                                        element={<Events />}
                                    />
                                </Routes>
                            </div>
                            <Footer />
                        </div>
                    </BrowserRouter>
                </div>
            </SidebarContext.Provider>
        </>
    );
};

export default App;

// SEO - search engine optimization
// ACCESSIBILITY
