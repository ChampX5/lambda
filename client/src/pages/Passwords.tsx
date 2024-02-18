// import { useState, useEffect } from 'react';

import { Header } from '../components';

import { useContext, useState, useEffect } from 'react';
import { SidebarContext } from '../App';

import { PiCopySimple } from 'react-icons/pi';

interface PasswordObjectType {
    platform: Company;
    username?: string;
    password: string;
}

interface Company {
    imageUrl: string;
    name: string;
}

const Passwords = () => {
    const [sidebarOpen, _] = useContext(SidebarContext);

    const [passwords, setPasswords] = useState<PasswordObjectType[]>([]);

    useEffect(() => {
        const fetchData = async () => {
            const res = await fetch('http://localhost:3001/passwords');
            const passwords = await res.json();
            return passwords;
        }

        fetchData().then(data => setPasswords(data));
    }, []);

    function generatePasswordPlaceholder(password: PasswordObjectType) {
        let string = '';

        const length = password.password.length; // random length between 5 and 10
        for (let i = 0; i < length; i++) {
            string = `${string}*`;
        }

        return string;
    }

    return (
        <>
            <Header title='My Passwords' type='Manager' />

            <div
                className={`grid w-full xl:grid-cols-3 lg:grid-cols-2 ${
                    sidebarOpen ? 'md:grid-cols-1' : 'md:grid-cols-2'
                } gap-x-3 gap-y-3 px-3`}
            >
                {passwords.map((password) => (
                    <div className='rounded-lg border-gray-200 border-2 border-solid p-3'>
                        {/* company bar */}
                        <div className='flex items-center gap-5'>
                            <img
                                src={password.platform.imageUrl}
                                className='w-12 rounded-2xl'
                            />

                            <span className='font-semibold'>
                                {password.platform.name}
                            </span>
                        </div>

                        <hr className='mt-3 border-gray-300 w-11/12 mx-auto' />

                        {/* username */}
                        <div className='mt-3 flex flex-col gap-y-2'>
                            <div
                                className={`${
                                    password.username
                                        ? 'bg-slate-50 border-slate-200 select-none'
                                        : 'bg-red-50 border-red-100 cursor-default'
                                } rounded-lg border-2 border-solid px-2 py-1 font-semibold`}
                            >
                                {password.username ? (
                                    <div className='flex flex-row items-center justify-between gap-3'>
                                        {password.username}{' '}
                                        <span
                                            onClick={() => {
                                                if (!password.username) return;

                                                navigator.clipboard.writeText(
                                                    password.username
                                                );
                                            }}
                                            className='font-lg transition-all duration-300 hover:text-white-main rounded-full hover:bg-gray-500 p-1 cursor-pointer'
                                        >
                                            <PiCopySimple />
                                        </span>
                                    </div>
                                ) : (
                                    'No username provided.'
                                )}
                            </div>

                            <div className='bg-slate-50 border-slate-200 font-["Cascadia_Code"] select-none rounded-lg border-2 border-solid px-2 py-1 font-semibold'>
                                {generatePasswordPlaceholder(password)}
                            </div>
                        </div>

                        {/* passwords - modal to open up */}
                    </div>
                ))}
            </div>
        </>
    );
};

export default Passwords;
