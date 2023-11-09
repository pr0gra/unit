"use client";

import "./globals.css";
import { Inter } from "next/font/google";
import { useState } from "react";
import Link from "next/link";
import Image from "next/image";

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
        {children}
        <div className="bg-black text-white">
          <div className="max-w-7xl mx-auto pt-10 flex justify-between text-sm px-8">
            <div className="w-[500px]">
              <div className="text-3xl font-bold mb-4">
                юнит
              </div>
              <div>
                ЮНИТ - первое студенческое IT объединение в Екатеринбурге,
                которое базируется в Уральском Экономическом университете
                (УРГЭУ).
              </div>
              <div>
                Мы верим, что будущее можно создать вместе и реальные проекты
                разрабатывать уже будучи студентами
              </div>
            </div>
            <div className="w-[356px]">
              <div className="font-bold mb-2 mt-4">Документы</div>
              <div className="mb-12">
                Политика обработки персональных данных
              </div>
              <div className="font-bold mb-4">Мы в социальных сетях</div>
              <div className="flex gap-3 mb-20">
                <Image alt="" src="/vk.png" height={40} width={40} />
                <Image alt="" src="/tg.png" height={40} width={40} />
                <Image alt="" src="/yt.png" height={40} width={40} />
              </div>
            </div>
          </div>
        </div>
      </body>
    </html>
  );
}
