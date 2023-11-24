"use client";

import Link from "next/link";
import { useSelectedLayoutSegment } from "next/navigation";

export default function Layout({ children }: { children: React.ReactNode }) {
  const segment = useSelectedLayoutSegment();

  return (
    <div className="pb-20">
      <div className="text-4xl py-8 flex justify-center">юнит</div>
      <div className="flex justify-center text-sm space-x-8">
        <Link className="px-6 py-1" href="/">
          О нас
        </Link>
        <Link className={`px-6 py-1${segment === "p" ? " bg-black rounded-full text-white" : ""}`} href="/p">
          Проекты
        </Link>
        <Link className={`px-6 py-1${segment === "a" ? " bg-black rounded-full text-white" : ""}`} href="/a">
          Авторы
        </Link>
      </div>
      {children}
    </div>
  );
}
