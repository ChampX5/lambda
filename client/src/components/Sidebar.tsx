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

import { useContext } from 'react';
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
                sidebarOpen ? 'mr-3' : 'mr-0'
            } transition-[margin-right] text-lg md:text-2xl`}
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
        <Link to={url}>
            <div
                className={`p-5 py-4 flex justify-start items-center rounded-xl mb-3 hover:bg-blue-300 hover:text-white-main transition-all duration-300`}
            >
                <SidebarIcon icon={icon} sidebarOpen={sidebarOpen} />

                <div
                    className={`${
                        sidebarOpen
                            ? 'opacity-1 pointer-events-auto'
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
                    ? 'w-72 bg-slate-100'
                    : 'md:w-[5.5rem] w-0 text-transparent pointer-events-none md:pointer-events-auto md:text-black'
            } fixed top-0 left-0 md:bg-slate-100 h-screen transition-all duration-300 px-3 pt-3`}
        >
            <div
                className={`${
                    sidebarOpen ? 'rotate-180' : 'rotate-0'
                } rounded-full text-3xl absolute top-3 md:top-6 text-black pointer-events-auto -right-3 transition-all duration-300 ease-in-out`}
            >
                <BiRightArrowCircle
                    onClick={() => setSidebarOpen(!sidebarOpen)}
                />
            </div>

            <div>
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
