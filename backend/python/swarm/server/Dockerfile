FROM centos:7
USER  0

EXPOSE 5000 

ADD conda3 /conda3
ADD server /server
RUN yum -y install cyrus-sasl-plain  cyrus-sasl-devel  cyrus-sasl-gssapi krb5-workstation  sssd-krb5

CMD /bin/sh /server/run_server.sh
