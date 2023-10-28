import {
    FaDollarSign,
    FaHome,
    FaCalculator,
    FaClock,
    FaSun,
    FaLock,
    FaCalendar
} from 'react-icons/fa';

import { BiRightArrowCircle } from 'react-icons/bi';

import { useState } from 'react';

import { Link } from 'react-router-dom';

interface SidebarIconPropsType {
    icon: JSX.Element;
    sidebarOpen: boolean;
}

const SidebarIcon = ({ icon, sidebarOpen }: SidebarIconPropsType) => {
    return (
        <div
            className={`w-5 h-5 flex justify-center items-center text-3xl ${
                sidebarOpen && 'mr-4'
            } transition-[margin-right] duration-300`}
        >
            {icon}
        </div>
    );
};

interface SidebarButtonPropsType {
    text: String;
    icon: JSX.Element;
    url: string;
    sidebarOpen: boolean;
}

const SidebarButton = ({
    text,
    icon,
    url,
    sidebarOpen
}: SidebarButtonPropsType) => {
    return (
        <Link to={url} className='w-full'>
            <div className='w-full flex font-semibold p-4 px-5 justify-start items-center rounded-xl hover:bg-blue-300 hover:text-white-main cursor-pointer transition-all duration-300'>
                <SidebarIcon icon={icon} sidebarOpen={sidebarOpen} />
                <div
                    className={`${
                        !sidebarOpen ? 'w-0 h-0 invisible' : ''
                    } transition-[transform] duration-300`}
                >
                    {text}
                </div>
            </div>
        </Link>
    );
};

const Sidebar = () => {
    const [sidebarOpen, setSidebarOpen] = useState(true);

    const sidebarItems = [
        {
            url: '/',
            text: 'Dashboard',
            icon: <FaHome />
        },
        {
            url: '/calc',
            text: 'Calculator',
            icon: <FaCalculator />
        },
        {
            url: '/time',
            text: 'Time Zones',
            icon: <FaClock />
        },
        {
            url: '/weather',
            text: 'Weather',
            icon: <FaSun />
        },
        {
            url: '/currency',
            text: 'Currency Converter',
            icon: <FaDollarSign />
        },
        {
            url: '/passwords',
            text: 'Password Manager',
            icon: <FaLock />
        },
        {
            url: '/calender',
            text: 'Your Events',
            icon: <FaCalendar />
        }
    ];

    return (
        <div
            className={`${
                sidebarOpen
                    ? 'w-72 bg-slate-100 text-black'
                    : 'bg-transparent text-transparent'
            } lg:bg-slate-100 lg:text-black p-4 fixed lg:relative box-content h-screen transition-all duration-300 ease-in-out`}
        >
            <div
                className={`${
                    !sidebarOpen && 'left-2 text-black'
                } absolute lg:top-2 lg:left-auto lg:-right-4 bg-gray-200 text-3xl rounded-full cursor-pointer transition-all duration-300
                ${sidebarOpen && 'rotate-180 -right-4'}
            `}
                onClick={() => setSidebarOpen(!sidebarOpen)}
            >
                <BiRightArrowCircle />
            </div>
            <div className='flex flex-col gap-3'>
                {sidebarItems.map((link) => (
                    <SidebarButton
                        sidebarOpen={sidebarOpen}
                        url={link.url}
                        icon={link.icon}
                        text={link.text}
                    />
                ))}
            </div>
        </div>
    );
};

export default Sidebar;
