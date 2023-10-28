import { Sidebar, Footer } from './components';
import { Routes, Route, BrowserRouter } from 'react-router-dom';
// import { Passwords, Main, Calculator } from './pages';
import { Passwords, Main } from './pages';

const App = () => {
    return (
        <>
            <div className='flex h-full w-full'>
                <BrowserRouter>
                    <Sidebar />

                    <div className="w-full">
                        <div className='overflow-hidden'>
                            <Routes>
                                <Route path='/' element={<Main />} />
                                <Route path='/passwords' element={<Passwords />} />
                                {/* <Route path='/calc' element={<Calculator />} /> */}
                            </Routes>
                        </div>
                        <Footer />
                    </div>
                </BrowserRouter>
            </div>
        </>
    );
};

export default App;
