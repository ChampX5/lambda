import {
    FaDollarSign,
    FaHome,
    FaCalculator,
    FaClock,
    FaSun,
    FaLock,
    FaCalendar
} from 'react-icons/fa';

import logo from '../img/logo.svg';

import { BiRightArrowCircle } from 'react-icons/bi';

import { useContext, useState } from 'react';
import { SidebarContext } from '../App';

import { Link } from 'react-router-dom';

interface SidebarIconPropsType {
    icon: JSX.Element;
    sidebarOpen: boolean;
}

const SidebarIcon = ({ icon, sidebarOpen }: SidebarIconPropsType) => {
    return (
        <div
            className={`${
                sidebarOpen ? 'mr-3' : 'mr-0 opacity-0 md:opacity-100'
            } transition-all duration-300 text-lg md:text-2xl`}
        >
            {icon}
        </div>
    );
};

interface SidebarButtonPropsType {
    text: string;
    icon: JSX.Element;
    url: string;
    sidebarOpen: boolean;
    selectedTab: string;
    setSelectedTab: React.Dispatch<React.SetStateAction<string>>;
}

const SidebarButton = ({
    text,
    icon,
    url,
    sidebarOpen,
    selectedTab,
    setSelectedTab
}: SidebarButtonPropsType) => {
    return (
        <Link
            to={url}
            onClick={() => {
                setSelectedTab(url);
            }}
        >
            <div
                className={`${
                    url === selectedTab
                        ? sidebarOpen
                            ? 'bg-blue-200'
                            : 'md:bg-blue-200'
                        : 'bg-transparent'
                } p-5 py-4 flex justify-start items-center rounded-xl mb-3 hover:bg-blue-300 hover:text-white-main transition-all duration-300`}
            >
                <SidebarIcon icon={icon} sidebarOpen={sidebarOpen} />

                <div
                    className={`${
                        sidebarOpen
                            ? 'opacity-100 pointer-events-auto'
                            : 'opacity-0 pointer-events-none'
                    } transition-opacity duration-300 whitespace-nowrap font-semibold`}
                >
                    {text}
                </div>
            </div>
        </Link>
    );
};

const Sidebar = () => {
    const [sidebarOpen, setSidebarOpen] = useContext(SidebarContext);
    const [selectedTab, setSelectedTab] = useState('/');

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
            url: '/calendar',
            text: 'Your Events',
            icon: <FaCalendar />
        }
    ];

    return (
        <div
            className={`${
                sidebarOpen
                    ? 'w-72 bg-slate-100'
                    : 'md:w-[5.5rem] w-0 text-transparent pointer-events-none md:pointer-events-auto md:text-black'
            } fixed top-0 left-0 md:bg-slate-100 h-screen transition-all duration-300 px-3 pt-3`}
        >
            <div
                className={`${
                    sidebarOpen ? 'rotate-180' : 'rotate-0'
                } rounded-full text-3xl absolute top-3 md:top-6 text-black pointer-events-auto -right-3 transition-all duration-300 delay-200 ease-in-out cursor-pointer`}
            >
                <BiRightArrowCircle
                    onClick={() => setSidebarOpen(!sidebarOpen)}
                />
            </div>

            <div>
                <Link
                    to='/'
                    onClick={() => {
                        setSelectedTab('/');
                    }}
                >
                    <div
                        className={`px-2 flex justify-start items-center rounded-xl mb-3 transition-all duration-300`}
                    >
                        <span
                            className={`${
                                sidebarOpen ? 'mr-3' : 'mr-0'
                            } transition-[margin-right]`}
                        >
                            <img
                                src={logo}
                                alt='lg'
                                className={`h-12 aspect-square`}
                            />
                        </span>

                        <span
                            className={`${
                                sidebarOpen
                                    ? 'opacity-100 w-32 pointer-events-auto'
                                    : 'opacity-0 w-0 pointer-events-none'
                            } transition-all duration-300 whitespace-nowrap font-[Nunito] font-semibold text-3xl`}
                        >
                            LAMBDA
                        </span>
                    </div>
                </Link>

                <hr className='w-full mb-3 border-slate-300' />

                {sidebarItems.map((link) => (
                    <SidebarButton
                        sidebarOpen={sidebarOpen}
                        url={link.url}
                        icon={link.icon}
                        key={link.text}
                        text={link.text}
                        selectedTab={selectedTab}
                        setSelectedTab={setSelectedTab}
                    />
                ))}
            </div>
        </div>
    );
};

export default Sidebar;
