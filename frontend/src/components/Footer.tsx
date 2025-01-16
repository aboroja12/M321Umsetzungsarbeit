import React from 'react';

const Footer: React.FC = () => {
    return (
        <footer className="bg-gray-800 text-white p-4">
            <div className="container mx-auto text-center">
                <p>&copy; {new Date().getFullYear()} Shop. All rights reserved.</p>
                <p>
                    <a
                        href="https://github.com/your-repository"
                        target="_blank"
                        rel="noopener noreferrer"
                        className="text-blue-400 hover:underline"
                    >
                        GitHub Repository
                    </a>
                </p>
            </div>
        </footer>
    );
};

export default Footer;
