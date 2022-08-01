from apscheduler.schedulers.blocking import BlockingScheduler
import datetime
# advance python scheduler
# interval 특정 주기로 연속 실행할때 사용
# cron : crontab 형식으로 사용
def fn_interval():
    print('test interval')
    print(datetime.datetime.now())
def fn_cron(*args):
    for i in args:
        print(i)
    print('test cron')
    print(datetime.datetime.now())

sched = BlockingScheduler()
# interval
sched.add_job(fn_interval, 'interval', seconds=5)
# cron
sched.add_job(fn_cron, 'cron', hour=9, minute='21', args=[1, 2, 3])
sched.start()