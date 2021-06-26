# 1. install oracle instant client
rpm -ivh oracle-instantclient18.3-basic-18.3.0.0.0-1.x86_64.rpm
ln -s /usr/lib/oracle/18.3/client64/lib/libclntsh.so.18.1    /usr/lib/oracle/18.3/client64/lib/libclntsh.so
cat > /etc/ld.so.conf.d/oracle.conf <<EOF
/usr/lib/oracle/18.3/client64/lib
EOF
ldconfig

# 2. install package
pip install cx_oracle


# 3. sqlplus 可选
rpm -ivh oracle-instantclient18.3-sqlplus-18.3.0.0.0-1.x86_64.rpm
cat > /etc/ld.so.conf.d/oracle.conf <<EOF
/usr/lib/oracle/18.3/client64/lib
EOF
ldconfig
sqlplus user/password@ip:port/db
