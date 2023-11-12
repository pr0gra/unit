"use client";

import Link from "next/link";
import { useState } from "react";

export default function Author({ params }: { params: any }) {
  const [project, setProject] = useState(false);

  function toggleProject() {
    setProject(!project);
  }

  return (
    <>
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
    </>
  );
}
