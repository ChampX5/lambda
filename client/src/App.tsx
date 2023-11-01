import { Sidebar, Footer } from './components';
import { Routes, Route, BrowserRouter } from 'react-router-dom';
// import { Passwords, Main, Calculator } from './pages';
import { Passwords, Main } from './pages';

import { useState, createContext, useContext } from 'react';
import React from 'react';

export const SidebarContext = createContext<[boolean, React.Dispatch<React.SetStateAction<boolean>>]>([true, () => {}]);

const App = () => {
    const [sidebarOpen, setSidebarOpen] = useState(true);

    return (
        <>
            <SidebarContext.Provider value={[sidebarOpen, setSidebarOpen]}>
                <div className='flex h-screen w-screen'>
                    <BrowserRouter>
                        <Sidebar />

                        <div className={`${sidebarOpen ? 'md:pl-72' : 'md:pl-[5.5rem]'} transition-all duration-300 w-full overflow-x-hidden`}>
                            <div className='overflow-y-auto'>
                                <Routes>
                                    <Route path='/' element={<Main />} />
                                    <Route
                                        path='/passwords'
                                        element={<Passwords />}
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
