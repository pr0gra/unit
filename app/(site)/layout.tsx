import Link from "next/link";

export default function Layout({ children }: { children: React.ReactNode }) {
  return (
    <div className="pb-20">
      <div className="text-4xl py-8 flex justify-center">юнит</div>
      <div className="flex justify-center text-sm space-x-8">
        <Link className="px-6 py-1" href="/">
          О нас
        </Link>
        <Link className="px-6 py-1" href="/p">
          Проекты
        </Link>
        <Link className="px-6 py-1" href="/a">
          Авторы
        </Link>
      </div>
      {children}
    </div>
  );
}
