"use client";

import "./globals.css";
import { Inter } from "next/font/google";
import { useState } from "react";
import Link from "next/link";

const inter = Inter({
  subsets: ["latin", "cyrillic"],
  display: "swap",
});

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  const [profile, setProfile] = useState(false);

  function openProfile() {
    setProfile(true);
  }

  function closeProfile() {
    setProfile(false);
  }

  return (
    <html lang="en" className={`${inter.className}`}>
      <body>
        <button
          onClick={openProfile}
          className="bg-white fixed top-0 right-0 rounded-full mt-8 mr-8 flex items-center gap-3 border border-gray-300 pr-4"
        >
          <div className="bg-gray-300 h-[48px] w-[48px] rounded-full"></div>
          <svg
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
            stroke-width="1.5"
            stroke="currentColor"
            className="w-4 h-4 stroke-gray-500"
          >
            <path
              stroke-linecap="round"
              stroke-linejoin="round"
              d="M19.5 8.25l-7.5 7.5-7.5-7.5"
            />
          </svg>
        </button>
        {profile && (
          <>
            <div
              onClick={closeProfile}
              className="bg-black opacity-50 fixed inset-0"
            ></div>
            <div className="bg-white fixed top-0 right-0 mt-8 mr-8 w-[310px] rounded-2xl text-center">
              <button onClick={closeProfile} className="p-4 absolute right-0">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 24 24"
                  stroke-width="1.5"
                  stroke="currentColor"
                  className="w-4 h-4 stroke-gray-500"
                >
                  <path
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    d="M4.5 15.75l7.5-7.5 7.5 7.5"
                  />
                </svg>
              </button>
              <div className="bg-gray-300 h-[100px] w-[100px] rounded-full mx-auto mt-10"></div>
              <div className="py-3 font-medium">Григорий Маманов</div>
              <hr />
              <button className="block w-full py-3">Личный профиль</button>
              <button className="block w-full py-3">Создать проект</button>
              <Link
                href="/settings"
                onClick={closeProfile}
                className="block w-full py-3"
              >
                Настройки
              </Link>
              <hr />
              <button className="pb-4 w-full py-3">Выйти</button>
            </div>
          </>
        )}
        <div>{children}</div>
        <div className="bg-black flex justify-center py-8">
          <svg
            width="86"
            height="98"
            viewBox="0 0 86 98"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <g clip-path="url(#clip0_9_52)">
              <path
                d="M1.61328 24.5848L43.0513 1.89844"
                stroke="white"
                stroke-width="3"
                stroke-linecap="round"
              />
              <path
                d="M84.3872 73.7539L42.9492 96.4404"
                stroke="white"
                stroke-width="3"
                stroke-linecap="round"
              />
              <path
                d="M1.61328 25.9209H84.3883"
                stroke="white"
                stroke-width="3"
                stroke-linecap="square"
              />
              <path
                d="M1.61328 72.418H84.3883"
                stroke="white"
                stroke-width="3"
                stroke-linecap="square"
              />
              <path
                d="M84.3867 25.9209V72.4178"
                stroke="white"
                stroke-width="3"
                stroke-linecap="square"
              />
              <path
                d="M43 72.4177V95.1317"
                stroke="white"
                stroke-width="3"
                stroke-linecap="square"
              />
              <path
                d="M1.61329 25.9209L1.61328 72.4178"
                stroke="white"
                stroke-width="3"
                stroke-linecap="square"
              />
              <path
                d="M43.2148 1.88593L84.4029 24.6383"
                stroke="white"
                stroke-width="3"
                stroke-linecap="round"
              />
              <path
                d="M42.7859 96.4527L1.59766 73.7002"
                stroke="white"
                stroke-width="3"
                stroke-linecap="round"
              />
              <path
                d="M84.1036 71.2451L63.8242 26.3506"
                stroke="white"
                stroke-width="3"
                stroke-linecap="round"
              />
              <path
                d="M42.4474 71.2451L22.168 26.3506"
                stroke="white"
                stroke-width="3"
                stroke-linecap="round"
              />
              <path
                d="M43.6797 70.6473L63.7945 26.8483"
                stroke="white"
                stroke-width="3"
                stroke-linecap="round"
              />
              <path
                d="M2.29297 70.6472L22.4079 26.8481"
                stroke="white"
                stroke-width="3"
                stroke-linecap="round"
              />
              <path
                d="M44.0879 2.56641L63.8569 25.9087"
                stroke="white"
                stroke-width="3"
                stroke-linecap="round"
              />
              <path
                d="M43.1493 1.88379L22.8574 25.5054"
                stroke="white"
                stroke-width="3"
                stroke-linecap="round"
              />
            </g>
            <defs>
              <clipPath id="clip0_9_52">
                <rect width="86" height="97.8039" fill="white" />
              </clipPath>
            </defs>
          </svg>
        </div>
      </body>
    </html>
  );
}
