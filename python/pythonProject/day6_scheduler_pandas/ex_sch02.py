# 실행 job 종료
from apscheduler.schedulers.blocking import BlockingScheduler
import datetime
sched = BlockingScheduler()
def job():
    print('ex job')
    print(datetime.datetime.now())

def job2():
    print('ex job2')
    print(datetime.datetime.now())
    job_instence = sched.get_job('job1')
    if job_instence:
        sched.remove_job('job1')
        
sched.add_job(job, 'interval', seconds=1, id='job1')
sched.add_job(job2, 'cron', second='*/3', id='job2')
sched.start()
