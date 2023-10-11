import { Sidebar } from './components';
import { Routes, Route, BrowserRouter } from 'react-router-dom';
import { Passwords, Main } from './pages';

const App = () => {
    return (
        <>
            <div className='flex h-screen w-full'>
                <BrowserRouter>
                    <Sidebar />

                    <div className='flex justify-center h-full items-center w-full'>
                        <Routes>
                            <Route path='/' element={<Main />} />

                            <Route path='/passwords' element={<Passwords />} />
                        </Routes>
                    </div>
                </BrowserRouter>
            </div>
        </>
    );
};

export default App;
