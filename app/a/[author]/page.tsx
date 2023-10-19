"use client";

import Link from "next/link";
import { useState } from "react";

export default function Author({ params }: { params: any }) {
  const [profile, setProfile] = useState(false);
  const [project, setProject] = useState(false);

  function openProfile() {
    setProfile(true);
  }

  function closeProfile() {
    setProfile(false);
  }

  function toggleProject() {
    setProject(!project);
  }

  return (
    <div className="pb-20">
      <button
        onClick={openProfile}
        className="fixed top-0 right-0 rounded-full mt-8 mr-8 flex items-center gap-3 border border-gray-300 pr-4"
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
            <button className="block w-full py-3">Настройки</button>
            <hr />
            <button className="pb-4 w-full py-3">Выйти</button>
          </div>
        </>
      )}
      <div className="text-4xl py-8 flex justify-center">юнит</div>
      <div className="flex justify-center text-sm space-x-8">
        <Link className="px-6 py-1" href="/">
          О нас
        </Link>
        <Link className="px-6 py-1" href="/">
          Проекты
        </Link>
        <Link className="px-6 py-1" href="/">
          Авторы
        </Link>
      </div>
      <div className="flex justify-center gap-6 items-center mt-20">
        <div className="bg-gray-300 rounded-full h-[150px] w-[150px]"></div>
        <div>
          <div className="text-3xl">Григорий Маманов</div>
          <div className="text-gray-500">Программист</div>
        </div>
      </div>
      <div className="max-w-7xl mx-auto mt-10">
        <div className="flex text-sm space-x-8">
          <Link className="bg-black text-white rounded-full px-6 py-1" href="/">
            Участие в проектах
          </Link>
          <Link className="px-6 py-1" href="/">
            Публикации
          </Link>
          <Link className="px-6 py-1" href="/">
            Об авторе
          </Link>
          <div className="relative">
            <button
              onClick={toggleProject}
              className={`px-4 py-1 border-2 border-black flex items-center w-[170px] gap-2 ${
                project ? "rounded-t-2xl" : "rounded-2xl"
              }`}
            >
              <div>Создать проект</div>
              <svg
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                stroke-width="1.5"
                stroke="currentColor"
                className="w-4 h-4"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  d="M19.5 8.25l-7.5 7.5-7.5-7.5"
                />
              </svg>
            </button>
            {project && (
              <div className="bg-white absolute border-x-2 border-b-2 w-[170px] border-black px-4 py-1 rounded-b-2xl">
                <button className="py-1 w-full text-left">Проект</button>
                <button className="py-1 w-full text-left">Публикацию</button>
              </div>
            )}
          </div>
        </div>
        <div className="mt-10 grid grid-cols-3 gap-2">
          <div className="rounded-2xl w-full bg-gray-300 h-[200px]"></div>
          <div className="rounded-2xl w-full bg-gray-300 h-[200px]"></div>
          <div className="rounded-2xl w-full bg-gray-300 h-[200px]"></div>
          <div className="rounded-2xl w-full bg-gray-300 h-[200px]"></div>
          <div className="rounded-2xl w-full bg-gray-300 h-[200px]"></div>
        </div>
      </div>
    </div>
  );
}
