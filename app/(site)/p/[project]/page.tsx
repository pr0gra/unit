import Link from "next/link";
import Image from "next/image";

export default function Project({ params }: { params: any }) {
  return (
    <div className="max-w-7xl mx-auto mt-10">
      <div className="text-sm mb-2 ml-4">
        <Link className="text-gray-400" href="/p">
          Проекты /{" "}
        </Link>
        Сайт ПРОФКОМ
      </div>
      <div className="w-full h-[665px] bg-gray-300 rounded-2xl flex justify-center items-center text-2xl text-gray-500 gap-2 cursor-pointer select-none">
        Нажмите, чтобы
        <span className="text-blue-600">загрузить\изменить</span>
        обложку проекта
      </div>
      <div className="flex mt-10 gap-6 items-start">
        <div className="w-full rounded-2xl border border-gray-300 px-8 pb-10">
          {/* <div className="my-20 text-4xl">Сайт ПРОФКОМ</div> */}
          <label className="my-8 block">
            <p>Введите название проекта</p>
            <input className="bg-gray-300 rounded-2xl px-4 py-3 mt-4 w-full" />
          </label>
          {/* <div>
            Профсоюзная организация студентов – это организация, призванная
            защищать законные права и интересы студентов. Проект был выполнен по
            заказу организации и по техническому заданию главного дизайнера и
            руководителя профсоюзной организации Уральского Экономического
            университета. Профсоюзная организация студентов – это организация,
            призванная защищать законные права и интересы студентов. Проект был
            выполнен по заказу организации и по техническому заданию главного
            дизайнера и руководителя профсоюзной организации Уральского
            Экономического университета.Профсоюзная организация студентов – это
            организация, призванная защищать законные права и интересы
            студентов. Проект был выполнен по заказу организации и по
            техническому заданию главного дизайнера и руководителя профсоюзной
            организации Уральского Экономического университета.
          </div> */}
          <label>
            <p>Введите описание проекта</p>
            <textarea
              rows={10}
              className="bg-gray-300 rounded-2xl px-4 py-3 mt-4 w-full"
            ></textarea>
          </label>
        </div>
        <div className="w-[600px] rounded-2xl border border-gray-300">
          <div className="w-full h-[120px] bg-gray-300 rounded-t-2xl gap-1 text-gray-500 flex justify-center items-center text-sm">
            Нажмите, чтобы{" "}
            <span className="text-blue-600">загрузить\изменить</span>
            обложку ссылок
          </div>
          <div className="px-8">
            {/* <div className="flex gap-3 justify-center my-8">
              <Image alt="" src="/vk.png" height={40} width={40} />
              <Image alt="" src="/tg.png" height={40} width={40} />
              <Image alt="" src="/yt.png" height={40} width={40} />
              <Image alt="" src="/be.png" height={40} width={40} />
            </div>
            <div className="text-lg">Интервью с командой</div>
            <div className="flex my-4 rounded-2xl border-gray-300 border px-6 items-center py-4 justify-between">
              <div className="text-sm">YouTube</div>
              <svg
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                stroke-width="1.5"
                stroke="currentColor"
                className="w-4 h-4 stroke-gray-400"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  d="M4.5 19.5l15-15m0 0H8.25m11.25 0v11.25"
                />
              </svg>
            </div>
            <div className="text-lg">Авторы проекта</div>
            <div className="flex gap-4 my-4 items-center">
              <div className="bg-gray-300 w-[50px] h-[50px] rounded-full"></div>
              <div>
                <div className="text-sm">Григорий Маманов</div>
                <div className="text-gray-400 text-xs mt-1">Программист</div>
              </div>
            </div>
            <div className="flex gap-4 my-4 items-center">
              <div className="bg-gray-300 w-[50px] h-[50px] rounded-full"></div>
              <div>
                <div className="text-sm">Григорий Маманов</div>
                <div className="text-gray-400 text-xs mt-1">Программист</div>
              </div>
            </div>
            <div className="flex gap-4 my-4 items-center">
              <div className="bg-gray-300 w-[50px] h-[50px] rounded-full"></div>
              <div>
                <div className="text-sm">Григорий Маманов</div>
                <div className="text-gray-400 text-xs mt-1">Программист</div>
              </div>
            </div>
            <div className="mb-8 text-xs text-gray-400 rounded-2xl border border-gray-300 py-2 text-center">
              Открыть полный список команды
            </div> */}
            <button className="block mx-auto bg-yellow-500 rounded-2xl text-sm py-4 w-[240px] my-10">
              Добавить ссылки
            </button>
            <button className="block mx-auto bg-yellow-500 rounded-2xl text-sm py-4 w-[240px] mb-10">
              Добавить авторов
            </button>
          </div>
        </div>
      </div>
      <div className="rounded-2xl border border-gray-300 mt-10">
        <div className="font-medium text-center text-lg mb-1 mt-16">
          История создания
        </div>
        {/* <div className="text-center text-gray-400 mb-10">
          Здесь вы увидите историю создания проекта - от идеи к финальному
          результату.
        </div> */}
        <div className="text-center text-red-500 mb-6 max-w-[700px] mx-auto">
          Вы можете удалить какой-либо отдел (дизайн, программирование или
          медиа),
          <br />
          если в вашем проекте нет участия данных специалистов или
        </div>
        <div className="flex justify-center text-sm space-x-3">
          <Link className="bg-black text-white rounded-full px-6 py-1" href="/">
            Дизайн
          </Link>
          <button className="bg-red-500 rounded-full w-6 h-6 text-white mt-1 pb-0.5">
            x
          </button>
          <div className="w-1"></div>
          <Link
            className="px-6 py-1 border border-gray-300 rounded-full"
            href="/"
          >
            Программирование
          </Link>
          <button className="bg-red-500 rounded-full w-6 h-6 text-white mt-1 pb-0.5">
            x
          </button>
          <div className="w-1"></div>
          <Link
            className="px-6 py-1 border border-gray-300 rounded-full"
            href="/"
          >
            Медиа
          </Link>
          <button className="bg-red-500 rounded-full w-6 h-6 text-white mt-1 pb-0.5">
            x
          </button>
        </div>
        <div className="w-full bg-gray-300 h-[400px] rounded-2xl mt-12"></div>
        <div className="flex px-8 py-16 gap-16">
          Был сделан первичный концепт в чёрно-белом варианте. После этого
          согласовали логику сайта и всех элементов - создали прототип.
          Протестировали и вуаля - финальный дизайн сайта. Проект сайта дал мне
          возможность реализовать все свои творческие задумки.
          <div className="flex w-[500px] items-center gap-4 border-l-2 pl-4 pr-[150px] border-gray-300">
            <div className="shrink-0 rounded-full bg-gray-300 h-[50px] w-[50px]"></div>
            <div>
              <div className="text-sm whitespace-nowrap">Артемий Фемидов</div>
              <div className="text-gray-400 text-xs mt-1">Дизайнер проекта</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
